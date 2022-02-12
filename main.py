import pymysql

# Connection
con = pymysql.connect(host='220.149.31.104',
                      user='lora',
                      password='loralora',
                      db='loratest',
                      charset='utf8')

cursorObject = con.cursor()

print("connect successful!!")


# SQL query string
sqlQuery = "select port, sequence from dummydata where port ="


# Execute the sqlQuery
for i in range(4) :
    port = i + 10
    cursorObject.execute(sqlQuery+str(port)+";")

    # Fetch all the rows
    rows = cursorObject.fetchall()

    for row in rows:
        count++

# Close connection
con.commit()
con.close()
