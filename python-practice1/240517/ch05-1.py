# 클래스 학습
result = 0
result1 = 0
result2 = 0

# 기본의 배운 내용으로 만든 add 함수
def add1(num):   # 계산기1
    global result1
    result1 += num  # 결괏값(result)에 입력값(num) 더하기
    return result1  # 결괏값 리턴

def add2(num):  # 계산기2
    global result2
    result2 += num
    return result2

print(add1(3))  # 3
print(add1(4))  # 7
print(add2(3))  # 3
print(add2(7))  # 10

# 계산기3
class Calculator:
    def __init__(self):        # 생성자와 비슷한 역할
        self.result = 0        # result변수를 0으로 초기화 # self 필요
    
    def add(self, num):        # add 일반함수
        self.result = self.result + num
        return self.result
    
cal1 = Calculator() # 객체 생성 (실제 붕어빵) cal1에 대입 
cal2 = Calculator() # 먼저 class로 틀을 만들고 다시 호출하여 변수에 담을 수 있다.

a = cal1.add(3) #class Calculator 안에 있는 add함수를 호출
print(a)
