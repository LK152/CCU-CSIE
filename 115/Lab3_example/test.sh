for i in 1 50 500
do
    for j in 100 4096 8192 16384
    do
    echo "BUFFSIZE: ${j} \n${i}mb"
    time "./buffsize${j}" < "${i}mb_file_for_buffSize${j}"
    echo "\n"
    done
done

echo Part 4
time ./buffsize4096 < 512mb_file1
time ./buffsize4096 < 512mb_file2
time ./buffsize4096 < 512mb_file2

echo Part 5
time ./buffsize4096_fsync < 512mb_file3
time ./buffsize4096_fsync < 512mb_file4
time ./buffsize4096_fsync < 512mb_file4