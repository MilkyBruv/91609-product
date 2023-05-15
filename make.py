from os import system

sourcepath_args = "!"
files_args = ""
final_cmd = "javac -d classfiles -sourcepath "

with open("./comp_files.txt") as comp_file:

    files = comp_file.readlines()

for file in files:

    file = file.replace("\n", "")

    sourcepath_args += ";" + file
    files_args += file + " "

sourcepath_args = sourcepath_args.replace("!;", "")

final_cmd += sourcepath_args + " " + files_args

system(final_cmd)
