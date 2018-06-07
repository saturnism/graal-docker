package com.example.graal;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

@TargetClass(className = "io.netty.util.internal.PlatformDependent0")
final class Target_io_netty_util_internal_PlatformDependent0 {
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClassName = "java.nio.Buffer", name = "address")
	private static long ADDRESS_FIELD_OFFSET;
}
