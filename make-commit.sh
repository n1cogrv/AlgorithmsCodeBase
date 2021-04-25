fileList=()
problemCount=0

for file in ./src/main/java/leetcode/editor/en/*; do
  if [ -f "$file" ] && [[ "$file" == *Prbl*.java ]]; then
    fileList=("${fileList[@]}" "$file")
    ((problemCount++))
  fi
done

sed "s/REPLACEME/$problemCount/" ./README_TEMPLATE.md >./README.md

if [ -f "./table.temp" ]; then
  rm "./table.temp"
fi

for eachLeetcode in "${fileList[@]}"; do
  problemNum=$(echo "$eachLeetcode" | grep -Eo 'Prbl[[:digit:]]{1,5}' | sed 's/Prbl/Problem /' | xargs)
  problemName=$(grep '^//[[:blank:]]*java:' "$eachLeetcode" | cut -d':' -f2 | xargs)
  problemFileName=$(echo "$eachLeetcode" | grep -Eo 'Prbl[[:digit:]]{1,5}[a-zA-Z]*\.java$' | xargs)
  echo -e "| $problemNum | $problemName | [$problemFileName]($eachLeetcode) |" >>./table.temp
done

sort -k2n -t'|' ./table.temp >>./README.md

column -t -s'|' ./table.temp

if [ -f "./table.temp" ]; then
  rm "./table.temp"
fi

git add -A

read -r -p "Commit? [y/N] " response
if [[ "$response" =~ ^([yY][eE][sS]|[yY])$ ]]; then
  git commit -S -m "$(date) - ProblemCount: $problemCount"
  exit 0
else
  exit 0
fi
