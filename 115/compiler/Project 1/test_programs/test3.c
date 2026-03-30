float Array[5];

int add(int a, int b){
	return a + b;
}
//aHR0cHM6Ly93d3cueW91dHViZS5jb20vd2F0Y2g/dj1kUXc0dzlXZ1hjUSZsaXN0PVJEZFF3NHc5V2dYY1E=
int main(void){
	int num1 = 67;
	int num2 = 114514;
	while(num1 > 0){
        num2 = -num1;
		num2 = add(num1, num2);
		num1 = num1 - 1;
	}
	return 1;
}
