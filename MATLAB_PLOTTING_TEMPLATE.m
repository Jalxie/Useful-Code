ts=datenum('2018-08-01 11:05:01');
tf=datenum('2018-08-01 16:03:51');

t=linspace(ts,tf,4490);
% 
% 
% figure(1);
% plot(t, RemCap,'LineWidth',3);
% title('Battery Charging Test','fontsize',15);
% xlabel('Time','fontsize',15); % x-axis label
% ylabel('Charging capactiy','fontsize',15); % y-axis label
% datetick('x','HH:MM','keepticks');

T=[1:1:5380];
figure(2);
yyaxis left
plot(Lumen,'LineWidth',3);
xlabel('Time','fontsize',15); % x-axis label
ylabel('Lumen','fontsize',15); % y-axis label
yyaxis right
plot(Num1, T11);
hold on;
plot(Num2, T22,'b');
plot(Num3, T33,'g');;
title('Plug DEV-4','fontsize',15);
ylabel('Temperature','fontsize',15); % y-axis label
% datetick('x','HH:MM','keepticks');

% figure(3);
% yyaxis left
% plot(t, Voltage,'LineWidth',3);
% xlabel('Time','fontsize',15); % x-axis label
% ylabel('Battery Voltage','fontsize',15); % y-axis label
% yyaxis right
% plot(t, RemCap/9272*100,'LineWidth',3);
% title('Battery Voltage','fontsize',15);
% ylabel('Charging percentage','fontsize',15); % y-axis label
% datetick('x','HH:MM','keepticks');
% 
% 
% figure(4);
% yyaxis left
% plot(t, Temperature,'LineWidth',3);
% xlabel('Time','fontsize',15); % x-axis label
% ylabel('Temperature','fontsize',15); % y-axis label
% yyaxis right
% plot(t, RemCap/9272*100,'LineWidth',3);
% title('Temperature','fontsize',15);
% ylabel('Charging percentage','fontsize',15); % y-axis label
% datetick('x','HH:MM','keepticks');

% figure(3);
% yyaxis left
% plot(t2, T1, 'LineWidth',3);
% hold on;
% plot(t2, T2, 'LineWidth',3);
% xlabel('Time','fontsize',15); % x-axis label
% ylabel('Temperature','fontsize',15); % y-axis label
% yyaxis right
% plot(t1, lumens,'LineWidth',3);
% title('lumens and temperature 4.2V','fontsize',20);
% ylabel('Lumens','fontsize',20); % y-axis label
% datetick('x','HH:MM','keepticks');
legend({'Lumen','T1','T2','T3'}, 'FontSize', 20,'Location', 'best');% best location for legend
