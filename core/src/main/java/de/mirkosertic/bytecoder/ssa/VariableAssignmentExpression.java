/*
 * Copyright 2017 Mirko Sertic
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.mirkosertic.bytecoder.ssa;

import java.util.ArrayList;
import java.util.List;

public class VariableAssignmentExpression extends Expression {

    private final Variable variable;
    private Value value;

    public VariableAssignmentExpression(Variable aVariable, Value aValue) {
        if (aValue == null) {
            throw new IllegalStateException("Null not allowed");
        }
        variable = aVariable;
        value = aValue;
    }

    public Variable getVariable() {
        return variable;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public void replaceIncomingDataEdge(Value aOldValue, Value aNewValue) {
        if (value == aOldValue) {
            value = aNewValue;
        }
    }

    @Override
    public <T extends Value> List<T> incomingDataFlows() {
        List<T> theResult = new ArrayList<>();
        theResult.add((T) value);
        return theResult;
    }
}