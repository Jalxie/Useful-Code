R1 = 0
R2 = 1000
for i in range(1,1000,1):
	R1 = 1/(1/0.25+1/i)

	if (R1 - 0.23) < (R2 - 0.23):
		R2 = R1

print(R2)
