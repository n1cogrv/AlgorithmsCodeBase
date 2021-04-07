#if (${PACKAGE_NAME} && ${PACKAGE_NAME} != "")package ${PACKAGE_NAME};#end
#parse("File Header.java")

import java.util.stream.Stream;

public class ${NAME} {
    public static void main(String[] args) {
        Stream.of().map(
            instance -> new ${NAME}().new Solution().HERE()
        ).forEach(System.out::println);
    }
    
    class Solution {
        
    }
}
