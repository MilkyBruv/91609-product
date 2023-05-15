from os import system, getcwd

sourcepath_args = ""
files_args = "!"
final_cmd = "javac -d classfiles -sourcepath "

with open("./comp_files.txt") as comp_file:

    files = comp_file.readlines()

for file in files:

    sourcepath_args += ";" + file
    files_args += file + " "

sourcepath_args.replace("!;", "")

final_cmd += sourcepath_args + " " + files_args

system(final_cmd)
