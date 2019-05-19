# Test
# Our attempt is at transposing columns to rows and rows to column
# for file with two columns right now.
# @Shaela ,18th April , Tuesday 
#



## Try 3 
import numpy as np
#x = np.array([[1,2,3],[4,5,6],[7,8,9],[10,11,12]])
#x = x.T
#print(x)
#print("\n")

# this is where the realcode starts #
import xlrd
import csv

sheet_data = []   
explist = xlrd.open_workbook('tinySampleCT.xlsx') #hold file object
p = explist.sheet_names()


for y in p:
   sh = explist.sheet_by_name(y)
   for rownum in range(sh.nrows): # made a change here to xrange 
      sheet_data.append((sh.row_values(rownum)))

found_list = []
for i in sheet_data: 
    found_list.append(i)  # parse thru the file and save as list caling it found_list
     

#prepare to transpose the list we get the genes with their own columns 
xy  = np.array(found_list)
xy  = xy.T


#print(found_list);print("\n"+"Original ")
print("***********************************************************************************")
#print(xy)
#print("\n"+"Transposed List")
print("***********************************************************************************")


with open("Output2.csv",'w') as resultFile:
    wr = csv.writer(resultFile, dialect='excel')
    wr.writerows(xy)    # xy should be the new transposed array


# Bunch of print stmnts to make you feel like, you have it working! :D
print ("Pause for dramatic Effect ! :D ")
print ("\n")
print("\n")
print("Complete")
