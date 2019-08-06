with open('Headlamps RawData.csv') as reader, open('newfile.csv', 'w') as writer:
    for index, line in enumerate(reader):
        if index % 6 == 0:
            writer.write(line)  