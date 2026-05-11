void main(void)
{
  int num;
  int index;
  float value;
  float value; // error: redeclared

  k = 0; // error: undeclared
  num = index + 3.21; // error: int + float, then int = error
  value = 1.5;
  num = value; // error: int = float
}
