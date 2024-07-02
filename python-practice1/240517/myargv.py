# 문제4
import sys # sys모듈

args = sys.argv[1:]
result = 0

for i in args: # i는 타입이 str
    result = result + int(i)

print(result)

