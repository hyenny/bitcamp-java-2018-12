
package ch02;

//콘솔로 출력하기2 - 형식으로 갖춰 출력하
public class Test11 {

    public static void main(String[] args) {

        System.out.printf("Hello!\n");
        
        //%s : 지정한 자리에 문자열을 삽입한다.
         //      삽입할 값은 오른쪽에 설정한다.
        System.out.printf("이름: %s\n", "홍길동");
        System.out.printf("안녕하세요! %s입니다\n", "임꺽정");
        
        //%d : 정수 값을 10진수 문자열로 만들어 삽입한다.
        //%x : 정수 값을 16진수 문자열로 만들어 삽입한다.
        // %c : 정수 값을 문자로 만들어 삽입한다.
        // %b : true/false 값을 문자열로 만들어 삽입한다.
        System.out.printf("%d %x %c %b\n", 65, 65, 65, true);
        
        //한 개의 값을 여러 곳에 삽입할 수 있다.
        //%[n$]s : n은 값의 순서를 지정한다. 순서는 1부터 증가한다.
        System.out.printf("%2$d %2$x %2$c\n", 65, 66, 67);
        
        //값을 출력할 때 사용할 공간을 지정할 수 있다.
        // %[-] [사용할공간너비]s : -는 왼쪽 정렬이다. 안 붙이면 기본 오른쪽 정렬이다.
        System.out.printf("'%s' '%s'\n","홍길동","임꺽정");
        System.out.printf("");
        
        // %[0][사용할공간너비]d : 앞의 빈자리는 0으로 채운다.
        //%[+]
        System.out.printf("'%010d' '%07d'\n", 12345, 12345);
        System.out.printf("'%+010d' '%+07d'\n", 12345, 12345);
        
        


        

    }
    
}

//# 문자 제어 코드 = 이스케이프 문자(escape character)
//- 화면에 출력하는 문자가 아니라 
//- 제어 문자
// \n 





