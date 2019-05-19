# Simple HBase Connection Service

This is simple HBase connection Service and using Java API Single PUT to update the existing customer information.

## To Create a CustomerInfo table using HBase Shell
'''
>create 'customerInfo', 'customer'
'''
After creating a table, run the service using following command to update the customer information using MR Single PUT Java API.

## To run the service

'''
>mvn clean install (or) mvn clean pacakge

'''

## To view the result using scan command in the hbase shell
'''
1.8.7-p357 :004 > scan 'customerInfo'
ROW                                                    COLUMN+CELL                                                                                                                                                   
\x99e\x95t\xB2\xB2\x8B\xF2\xF1B\xA4A\x0B\x94\xDA\xD3 column=customer:firstName, timestamp=1558250880422, value=Bharati                                                                                             
s\xC4\xC9t\xA0\x81\x1C1Sy\xF3y\xBB\xF03                                                                                                                                                                             
>\x99e\x95t\xB2\xB2\x8B\xF2\xF1B\xA4A\x0B\x94\xDA\xD3 column=customer:lastName, timestamp=1558250880422, value=Kannamma                                                                                             
s\xC4\xC9t\xA0\x81\x1C1Sy\xF3y\xBB\xF03                                                                                                                                                                             
>\x99e\x95t\xB2\xB2\x8B\xF2\xF1B\xA4A\x0B\x94\xDA\xD3 column=customer:role, timestamp=1558250880422, value=Test                                                                                                     
s\xC4\xC9t\xA0\x81\x1C1Sy\xF3y\xBB\xF03                                                                                                                                                                             
\xDB\xC0\x89 dN\x91Y\xBAxl\xDAN\xB4(\xFE7\x00~\x10\x8 column=customer:age, timestamp=1558249701091, value=23                                                                                                        
7\x82\x0AE\xC0\x98\x97\xC8\xEB&\xF6\xCF
'''