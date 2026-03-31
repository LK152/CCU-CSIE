for i in 1 50 500
do
    for j in 100 4096 8192 16384
    do
    dd if=/dev/zero of="${i}mb_file_for_buffSize${j}" bs=$j count=$(( i * 1024 * 1024 / j ))
    done
done

for i in 1 2 3 4
do
    dd if=/dev/zero of="512mb_file${i}" bs=4096 count=131072
done