T11 = [];
Num1 = [];
j=1;
Leng = length(Fluxlm);

for i = 1:Leng
    if ~isnan(T1(i))
        T11(j) = T1(i);
        Num1(j) = i;
        j = j+1;
    end
end

Leng = length(Lumen);
T22 = [];
Num2 = [];
j=1;
for i = 1:Leng
    if ~isnan(T2(i))
        T22(j) = T2(i);
        Num2(j) = i;
        j = j+1;
    end
end


T33 = [];
Num3 = [];
j=1;
for i = 1:Leng
    if ~isnan(T3(i))
        T33(j) = T3(i);
        Num3(j) = i;
        j = j+1;
    end
end