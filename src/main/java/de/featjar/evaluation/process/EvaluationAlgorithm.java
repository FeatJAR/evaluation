/*
 * Copyright (C) 2024 FeatJAR-Development-Team
 *
 * This file is part of FeatJAR-evaluation.
 *
 * evaluation is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3.0 of the License,
 * or (at your option) any later version.
 *
 * evaluation is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with evaluation. If not, see <https://www.gnu.org/licenses/>.
 *
 * See <https://github.com/FeatureIDE/FeatJAR-evaluation> for further information.
 */
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
