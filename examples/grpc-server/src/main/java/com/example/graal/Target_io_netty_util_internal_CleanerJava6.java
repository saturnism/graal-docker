package com.example.graal;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.CleanerJava6")
final class Target_io_netty_util_internal_CleanerJava6 {
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.DirectByteBuffer", name = "cleaner")
	private static long CLEANER_FIELD_OFFSET;
}
