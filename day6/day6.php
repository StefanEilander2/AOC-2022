<?php
$input = file('day6.txt', FILE_IGNORE_NEW_LINES);
$input = str_split($input[0]);

$length = 14;

for ($i = 0; $i <= sizeof($input) - $length; $i++) {
    $data = array_unique(array_slice($input, $i, $length));
    if (sizeof($data) === $length) {
        echo $i + $length . PHP_EOL;
        break;
    }
}