package com.epayments.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator.Feature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

/**
 * The type Service util.
 *
 * @author Kalidass Mahalingam         Helper functions to handle JsonNode values.
 */
public class ServiceUtil {
	private static final ObjectMapper defaultObjectMapper = newDefaultMapper();
	private static volatile ObjectMapper objectMapper = null;

    /**
     * New default mapper object mapper.
     *
     * @return the object mapper
     */
    public static ObjectMapper newDefaultMapper() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		return mapper;
	}

    /**
     * Get the ObjectMapper used to serialize and deserialize objects to and
     * from JSON values.
     * <p>
     * This can be set to a custom implementation using ServiceUtil.setObjectMapper.
     *
     * @return the ObjectMapper currently being used
     */
    public static ObjectMapper mapper() {
		if (objectMapper == null) {
			return defaultObjectMapper;
		} else {
			return objectMapper;
		}
	}

	private static String generateJson(Object o, boolean prettyPrint, boolean escapeNonASCII) {
		try {
			ObjectWriter writer = mapper().writer();
			if (prettyPrint) {
				writer = writer.with(SerializationFeature.INDENT_OUTPUT);
			}
			if (escapeNonASCII) {
				writer = writer.with(Feature.ESCAPE_NON_ASCII);
			}
			return writer.writeValueAsString(o);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * Convert an object to JsonNode.
     *
     * @param data Value to convert in ServiceUtil.
     *
     * @return the json node
     */
    public static JsonNode toJson(final Object data) {
		try {
			return mapper().valueToTree(data);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * Convert a JsonNode to a Java value
     *
     * @param <A>   the type parameter
     * @param json  ServiceUtil value to convert.
     * @param clazz Expected Java value type.
     *
     * @return the a
     */
    public static <A> A fromJson(JsonNode json, Class<A> clazz) {
		try {
			return mapper().treeToValue(json, clazz);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    /**
     * Creates a new empty ObjectNode.
     *
     * @return the object node
     */
    public static ObjectNode newObject() {
		return mapper().createObjectNode();
	}

    /**
     * Creates a new empty ArrayNode.
     *
     * @return the array node
     */
    public static ArrayNode newArray() {
		return mapper().createArrayNode();
	}

    /**
     * Convert a JsonNode to its string representation.
     *
     * @param json the json
     *
     * @return the string
     */
    public static String stringify(JsonNode json) {
		return generateJson(json, false, false);
	}

    /**
     * Convert a JsonNode to its string representation, escaping non-ascii
     * characters.
     *
     * @param json the json
     *
     * @return the string
     */
    public static String asciiStringify(JsonNode json) {
		return generateJson(json, false, true);
	}

    /**
     * Convert a JsonNode to its string representation.
     *
     * @param json the json
     *
     * @return the string
     */
    public static String prettyPrint(JsonNode json) {
		return generateJson(json, true, false);
	}

    /**
     * Parse a String representing a json, and return it as a JsonNode.
     *
     * @param src the src
     *
     * @return the json node
     */
    public static JsonNode parse(String src) {
		try {
			return mapper().readTree(src);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

    /**
     * Parse a InputStream representing a json, and return it as a JsonNode.
     *
     * @param src the src
     *
     * @return the json node
     */
    public static JsonNode parse(java.io.InputStream src) {
		try {
			return mapper().readTree(src);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

    /**
     * Parse a byte array representing a json, and return it as a JsonNode.
     *
     * @param src the src
     *
     * @return the json node
     */
    public static JsonNode parse(byte[] src) {
		try {
			return mapper().readTree(src);
		} catch (Throwable t) {
			throw new RuntimeException(t);
		}
	}

    /**
     * Inject the object mapper to use.
     * <p>
     * This is intended to be used when Play starts up. By default, Play will
     * inject its own object mapper here, but this mapper can be overridden
     * either by a custom module.
     *
     * @param mapper the mapper
     */
    public static void setObjectMapper(ObjectMapper mapper) {
		objectMapper = mapper;
	}

}
