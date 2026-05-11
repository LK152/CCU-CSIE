void main(void)
{
  int times;
  int idx;
  int sum;
  float ratio;

  times = 3;
  idx = 0;
  sum = 0;
  ratio = 0.5;

  // line comment
  while (idx < times) {
    sum = sum + idx;
    idx = idx + 1;
  }

  /* block comment */
  if (sum == 3) {
    sum = sum + times;
  } else {
    sum = sum - 1;
  }

  return;
}
