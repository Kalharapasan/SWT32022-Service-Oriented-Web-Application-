from lxml import etree

xml_file = "score.xml"
xsd_file = "score.xsd"

try:
    # Load XSD
    with open(xsd_file, 'rb') as f:
        schema_doc = etree.parse(f)
        schema = etree.XMLSchema(schema_doc)

    # Load XML
    with open(xml_file, 'rb') as f:
        xml_doc = etree.parse(f)

    # Validate
    is_valid = schema.validate(xml_doc)
    print("✅ XML is valid!" if is_valid else "❌ XML is invalid.")

    if not is_valid:
        for error in schema.error_log:
            print(f"Line {error.line}: {error.message}")

except Exception as e:
    print(f"Error: {e}")
