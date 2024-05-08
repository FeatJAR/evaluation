package de.featjar.evaluation.process;

import java.nio.file.Path;

public abstract class EvaluationAlgorithm extends Algorithm<Void> {

    private final String jarName;
    private final String command;
    private final Path input;
    private final Path output;
    private final Path time;

    public EvaluationAlgorithm(String jarName, String command, Path input, Path output) {
        this.jarName = jarName;
        this.command = command;
        this.input = input;
        this.output = output;
        this.time = output.resolveSibling("time");
    }

    @Override
    protected void addCommandElements() throws Exception {
        commandElements.add("java");
        commandElements.add("-jar");
        commandElements.add(String.format("build/libs/%s.jar", jarName));
        commandElements.add("--command");
        commandElements.add(command);
        commandElements.add("--input");
        commandElements.add(input.toString());
        commandElements.add("--output");
        commandElements.add(output.toString());
        commandElements.add("--write-time-to-file");
        commandElements.add(time.toString());
    }
}
