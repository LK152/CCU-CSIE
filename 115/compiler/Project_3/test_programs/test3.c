void main(void)
{
  int a;
  int b;
  float f;

  a = 5;
  b = 2;
  f = 1.0;

  if (a > b) a = 1;
  if (a) b = 1; // error: condition is int, not boolean
  if (a != b) a = 2;

  while (3 > 2) a = 0;
  while (f > b) a = 1; // error: float > int, then condition error
}
