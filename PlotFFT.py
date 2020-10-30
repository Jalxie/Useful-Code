import numpy as np 
import matplotlib.pyplot as plt # For Plotting
import xlrd # For import data from .xlsx file
import pandas as pd
from openpyxl import load_workbook
from pylab import figure, show, legend, ylabel

ydata = []
xdata = []
filename = 'filename.xlsx'
sheetname = 'Sheet1'

# Load in the workbook
wb = load_workbook(filename)

# Get sheet names
print(wb.get_sheet_names())
print('\n')
# Get a sheet by name 
sheet = wb.get_sheet_by_name(sheetname)

#print all the column name
for i in range(1, sheet.max_column):
     print(i, sheet.cell(row=1, column=i).value)

for i in range(2, sheet.max_row):
    if isinstance(sheet.cell(row=i, column=1).value,float):
        xdata.append(sheet1.cell(row=i, column=1).value)

for i in range(1, sheet.max_column):
     print(i, sheet.cell(row=1, column=i).value)

for i in range(2, sheet.max_row):
    if isinstance(sheet.cell(row=i, column=1).value,float):
        ydata.append(sheet1.cell(row=i, column=1).value)

"""
Plotting
"""
plt.figure(1)

plt.plot(xdata, ydata)


