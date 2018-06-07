package com.example.graal;

import com.oracle.svm.core.annotate.Alias;
import com.oracle.svm.core.annotate.RecomputeFieldValue;
import com.oracle.svm.core.annotate.TargetClass;

import java.nio.Buffer;

@TargetClass(className = "com.google.protobuf.UnsafeUtil")
final class Target_com_google_protobuf_UnsafeUtil {
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FromAlias)
	private static final sun.misc.Unsafe UNSAFE = null;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FromAlias)
	private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FromAlias)
	private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = byte[].class)
	private static long BYTE_ARRAY_BASE_OFFSET;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = boolean[].class)
	private static long BOOLEAN_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = boolean[].class)
	private static long BOOLEAN_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = int[].class)
	private static long INT_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = int[].class)
	private static long INT_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = long[].class)
	private static long LONG_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = long[].class)
	private static long LONG_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = float[].class)
	private static long FLOAT_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = float[].class)
	private static long FLOAT_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = double[].class)
	private static long DOUBLE_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = double[].class)
	private static long DOUBLE_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayBaseOffset, declClass = Object[].class)
	private static long OBJECT_ARRAY_BASE_OFFSET;
	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.ArrayIndexScale, declClass = Object[].class)
	private static long OBJECT_ARRAY_INDEX_SCALE;

	@Alias @RecomputeFieldValue(kind = RecomputeFieldValue.Kind.FieldOffset, declClass = Buffer.class, name = "address")
	private static long BUFFER_ADDRESS_OFFSET;
}
