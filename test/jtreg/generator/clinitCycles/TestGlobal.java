/* Copyright (c) 2023, 2025, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

import org.testng.annotations.Test;

import static org.testng.Assert.*;

import test.jextract.clinit.*;

import java.lang.foreign.ValueLayout;

/*
 * @test
 * @library /lib
 * @build testlib.TestUtils
 * @run main/othervm JtregJextract -t test.jextract.clinit --library ClinitGlobal --use-system-load-library -Djextract.decls.per.header=1 clinit_global.h
 * @build TestGlobal
 * @run testng/othervm --enable-native-access=ALL-UNNAMED TestGlobal
 */
public class TestGlobal {

    @Test
    public void testGlobal() {
        ValueLayout layout = LayoutUtils.C_INT;
        assertNotNull(layout);
        assertEquals(clinit_global_h.global1(), 1);
        assertEquals(clinit_global_h.global2(), 2);
    }
}
