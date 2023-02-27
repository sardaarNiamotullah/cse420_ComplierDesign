import re

inputFile = open("input_2.txt", "r").read().split("\n")

numberOfReg = int(inputFile[0])
numberOfTestCases = int(inputFile[numberOfReg+1])
regex = []
testData = []
printData = {}


for _ in range(1, numberOfTestCases):
    regex.append(inputFile[_])
for _ in range(numberOfReg+2, len(inputFile)):
    testData.append(inputFile[_])
for _ in testData:
    printData[_] = "NO, 0"

for _ in testData:
    x = 1
    for i in regex:
        regex_pattern = re.compile(i)
        result = regex_pattern.fullmatch(_)
        if (result != None):
            printData[_] = f"YES, {x}"
        x += 1

for _ in testData:
    print(printData[_])