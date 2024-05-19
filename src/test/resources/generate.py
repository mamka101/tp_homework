from random import randint

LOWER_BOUND = 10
UPPER_BOUND = 1000

number = int(input())

with open(f'{number}.txt', mode='w') as result_file:
    for i in range(number):
        result_file.write(str(randint(LOWER_BOUND, UPPER_BOUND)) + ' ')
