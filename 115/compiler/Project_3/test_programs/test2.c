void main(void)
{
  int a;
  int b;
  float f;
  int out;

  a = 10;
  b = 3;
  f = 2.5;

  out = a - b * 2 / 1;
  out = a % b;
  out = a % f; // error: int % float
  f = a + b; // error: float = int
}
