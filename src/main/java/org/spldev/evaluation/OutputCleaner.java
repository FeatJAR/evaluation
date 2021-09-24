/* -----------------------------------------------------------------------------
 * Evaluation Lib - Miscellaneous functions for performing an evaluation.
 * Copyright (C) 2021  Sebastian Krieter
 * 
 * This file is part of Evaluation Lib.
 * 
 * Evaluation Lib is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 * 
 * Evaluation Lib is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with Evaluation Lib.  If not, see <https://www.gnu.org/licenses/>.
 * 
 * See <https://github.com/skrieter/evaluation> for further information.
 * -----------------------------------------------------------------------------
 */
package org.spldev.evaluation;

import java.io.*;
import java.nio.file.*;

import org.spldev.util.logging.*;

public class OutputCleaner extends Evaluator {

	@Override
	public void evaluate() throws IOException {
		Files.deleteIfExists(config.outputRootPath.resolve(".current"));
		Logger.logInfo("Reset current output path.");
	}

	@Override
	public String getId() {
		return "eval-clean";
	}

	@Override
	public String getDescription() {
		return "Cleans current evaluation results";
	}
}
