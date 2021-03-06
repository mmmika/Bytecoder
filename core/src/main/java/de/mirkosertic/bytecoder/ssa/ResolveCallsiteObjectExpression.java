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

import de.mirkosertic.bytecoder.core.BytecodeClass;

public class ResolveCallsiteObjectExpression extends Expression {

    private final String callsiteId;
    private final BytecodeClass owningClass;
    private final Program program;
    private final RegionNode bootstrapMethod;

    public ResolveCallsiteObjectExpression(String aCallsiteId, BytecodeClass aOwningClass,
            Program aProgram, RegionNode aBootstrapMethod) {
        callsiteId = aCallsiteId;
        owningClass = aOwningClass;
        program = aProgram;
        bootstrapMethod = aBootstrapMethod;
    }

    public String getCallsiteId() {
        return callsiteId;
    }

    public BytecodeClass getOwningClass() {
        return owningClass;
    }

    public Program getProgram() {
        return program;
    }

    public RegionNode getBootstrapMethod() {
        return bootstrapMethod;
    }

    @Override
    public TypeRef resolveType() {
        return TypeRef.Native.REFERENCE;
    }
}
