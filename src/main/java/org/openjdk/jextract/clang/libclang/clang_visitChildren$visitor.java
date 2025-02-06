// Generated by jextract

package org.openjdk.jextract.clang.libclang;

import java.lang.invoke.*;
import java.lang.foreign.*;
import java.nio.ByteOrder;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.foreign.ValueLayout.*;
import static java.lang.foreign.MemoryLayout.PathElement.*;

import static org.openjdk.jextract.clang.libclang.FFMUtils.*;
import static org.openjdk.jextract.clang.libclang.LayoutUtils.*;

/**
 * {@snippet lang=c :
 * CXCursorVisitor visitor
 * }
 */
public class clang_visitChildren$visitor {

    clang_visitChildren$visitor() {
        // Should not be called directly
    }

    /**
     * The function pointer signature, expressed as a functional interface
     */
    public interface Function {
        int apply(MemorySegment _x0, MemorySegment _x1, MemorySegment _x2);
    }

    private static final FunctionDescriptor $DESC = FunctionDescriptor.of(
        C_INT,
        CXCursor.layout(),
        CXCursor.layout(),
        C_POINTER
    );

    /**
     * The descriptor of this function pointer
     */
    public static FunctionDescriptor descriptor() {
        return $DESC;
    }

    private static final MethodHandle UP$MH = upcallHandle(Function.class, "apply", $DESC);

    /**
     * Allocates a new upcall stub, whose implementation is defined by {@code fi}.
     * The lifetime of the returned segment is managed by {@code arena}
     */
    public static MemorySegment allocate(Function fi, Arena arena) {
        return Linker.nativeLinker().upcallStub(UP$MH.bindTo(fi), $DESC, arena);
    }

    private static final MethodHandle DOWN$MH = Linker.nativeLinker().downcallHandle($DESC);

    /**
     * Invoke the upcall stub {@code funcPtr}, with given parameters
     */
    public static int invoke(MemorySegment funcPtr,MemorySegment _x0, MemorySegment _x1, MemorySegment _x2) {
        try {
            return (int) DOWN$MH.invokeExact(funcPtr, _x0, _x1, _x2);
        } catch (Throwable ex$) {
            throw new AssertionError("should not reach here", ex$);
        }
    }
}
