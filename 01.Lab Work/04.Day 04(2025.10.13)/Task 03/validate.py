from lxml import etree

xml_file = "department.xml"
xsd_file = "department.xsd"

try:
    schema_doc = etree.parse(xsd_file)
    schema = etree.XMLSchema(schema_doc)
    xml_doc = etree.parse(xml_file)

    is_valid = schema.validate(xml_doc)
    print("✅ XML is valid!" if is_valid else "❌ XML is invalid.")

    if not is_valid:
        for error in schema.error_log:
            print(f"Line {error.line}: {error.message}")

except Exception as e:
    print(f"Error: {e}")
