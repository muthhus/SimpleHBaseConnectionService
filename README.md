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
\xDB\xC0\x89 dN\x91Y\xBAxl\xDAN\xB4(\xFE7\x00~\x10\x8 column=customer:age, timestamp=1558249701091, value=23                                                                                                        
7\x82\x0AE\xC0\x98\x97\xC8\xEB&\xF6\xCF                                                                                                                                                                             
\xDB\xC0\x89 dN\x91Y\xBAxl\xDAN\xB4(\xFE7\x00~\x10\x8 column=customer:firstName, timestamp=1558249701091, value=Muthu                                                                                               
7\x82\x0AE\xC0\x98\x97\xC8\xEB&\xF6\xCF                                                                                                                                                                             
\xDB\xC0\x89 dN\x91Y\xBAxl\xDAN\xB4(\xFE7\x00~\x10\x8 column=customer:lastName, timestamp=1558249701091, value=Sundaram                                                                                             
7\x82\x0AE\xC0\x98\x97\xC8\xEB&\xF6\xCF                                                                                                                                                                             
\xDB\xC0\x89 dN\x91Y\xBAxl\xDAN\xB4(\xFE7\x00~\x10\x8 column=customer:role, timestamp=1558249701091, value=CTO                                                                                                      
7\x82\x0AE\xC0\x98\x97\xC8\xEB&\xF6\xCF
'''