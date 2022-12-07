package aoc.y2022.Day7;

import aoc.FileReaderEnabledPuzzleSolver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Stack;

public class Day7Puzzle extends FileReaderEnabledPuzzleSolver {

    static class Directory {
        private final String name;
        private final List<Directory> directories = new ArrayList<>();
        private final List<File> files = new ArrayList<>();
        private Directory parent;
        private long size = 0L;


        Directory(String name) {
            this.name = name;
            this.parent = null;
        }

        public void addDirectory(String dirName) {
            if (this.directories.stream().noneMatch(directory -> directory.name.equals(dirName))) {
                Directory newDir = new Directory(dirName);
                this.directories.add(newDir);
                newDir.parent = this;
            }
        }

        public void addFile(File f) {
            this.files.add(f);
        }

        public long computeSize() {
            Optional<Long> fileSize = this.files.stream().map(file -> file.size).reduce(Long::sum);
            Optional<Long> directorySize = this.directories.stream().map(Directory::computeSize).reduce(Long::sum);
            this.size = fileSize.orElse(0L) + directorySize.orElse(0L);
            return this.size;
        }

        public Directory getDir(String dirName) {
            Optional<Directory> first = this.directories.stream().filter(directory -> directory.name.equals(dirName)).findFirst();
            if (first.isPresent()) {
                return first.get();
            }
            this.addDirectory(dirName);
            return getDir(dirName);
        }
    }

    static class File {
        private final long size;

        File(long size) {
            this.size = size;
        }

    }


    public Day7Puzzle(String fileName) throws FileNotFoundException {
        super(fileName);
    }

    public long solveP1() throws IOException {

        Directory parentDirectory = processCommands();
        Stack<Directory> flatDir = new Stack<>();
        parentDirectory.directories.forEach(flatDir::push);
        long targetFileSie = 0L;
        while (!flatDir.isEmpty()) {
            Directory dir = flatDir.pop();
            if (dir.size <= 100000) {
                targetFileSie += dir.size;
            }
            dir.directories.forEach(flatDir::push);
        }
        return targetFileSie;
    }

    public long solveP2() throws IOException {
        Directory parentDirectory = processCommands();
        long unusedSpace = 70000000 - parentDirectory.size;

        long placeToFreeUp = 30000000 - unusedSpace;
        Stack<Directory> flatDir = new Stack<>();
        parentDirectory.directories.forEach(flatDir::push);
        long maxSize = 0L;
        while (!flatDir.isEmpty()) {
            Directory dir = flatDir.pop();
            if (dir.size >= placeToFreeUp) {
                if (maxSize == 0L) {
                    maxSize = dir.size;
                } else {
                    if (dir.size < maxSize) {
                        maxSize = dir.size;
                    }
                }
            }
            dir.directories.forEach(flatDir::push);
        }

        return maxSize;
    }

    private Directory processCommands() throws IOException {
        Directory parentDirectory = new Directory("/");
        Directory navigationDirectory = parentDirectory;


        String line = getBufferedReader().readLine();
        while (line != null) {
            String[] split = line.split(" ");
            if (split[0].equals("$")) {
                if (split[1].equals("cd")) {
                    if (split[2].equals("/")) {
                        navigationDirectory = parentDirectory;
                    } else if (split[2].equals("..")) {
                        navigationDirectory = navigationDirectory.parent;
                    } else {
                        navigationDirectory = navigationDirectory.getDir(split[2]);
                    }
                    line = getBufferedReader().readLine();
                } else if (split[1].equals("ls")) {
                    line = getBufferedReader().readLine();
                    while ((line != null) && !(line.startsWith("$"))) {
                        String[] nextLineSplit = line.split(" ");
                        if (nextLineSplit[0].equals("dir")) {
                            navigationDirectory.addDirectory(nextLineSplit[1]);
                        } else {
                            navigationDirectory.addFile(new File(Long.parseLong(nextLineSplit[0])));
                        }
                        line = getBufferedReader().readLine();
                    }
                }
            }

        }
        parentDirectory.computeSize();
        return parentDirectory;
    }


}
