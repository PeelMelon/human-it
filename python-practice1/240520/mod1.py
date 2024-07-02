def add(a, b):
    return a + b

def sub(a, b):
    return a - b

print(add(1, 4))
print(sub(4, 2))

# __name__은 모듈이름을 출력한다.
if __name__ == "__main__": # 모듈로 사용시 아래 명령문은 실행하지 않도록 한다
    print(add(1, 4))
    print(sub(4, 2))
    pass