public class WritePoem {
public static void main(String[] args) {
String[] str = {"line one of the poem", "line two of the poem", "line three of the poem", "line 4 of the poem", "line 5 of the poem","line 6 of the poem","line 7 of the poem"};
printPoem(str);
}
private static void printPoem(String[] str) {
int k = str.length;
int n = 25;
int c = 2;
for(int i = 0; i < k; i++) {
for (int j = 0; j < c; j++) {
System.out.println(str[j]);
}
System.out.println(str[k-1]);
System.out.println("\t");
if ( c != k-1 ) {
c = c + 1;
}else
break;
}
}
}
