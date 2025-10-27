from lxml import etree

# File names — make sure these files are in the same folder as this script
xml_file = "employees.xml"
xsd_file = "employees.xsd"

try:
    # Parse the XSD (schema)
    with open(xsd_file, 'rb') as schema_file:
        schema_doc = etree.parse(schema_file)
        schema = etree.XMLSchema(schema_doc)

    # Parse the XML
    with open(xml_file, 'rb') as xml_data_file:
        xml_doc = etree.parse(xml_data_file)

    # Validate
    is_valid = schema.validate(xml_doc)
    print(f"✅ XML Validation Result: {is_valid}")

    if not is_valid:
        print("❌ Errors:")
        for error in schema.error_log:
            print(f"Line {error.line}: {error.message}")

except FileNotFoundError as e:
    print(f"🚫 File not found: {e.filename}")
except etree.XMLSchemaParseError as e:
    print(f"🚫 Schema error: {str(e)}")
except etree.XMLSyntaxError as e:
    print(f"🚫 XML syntax error: {str(e)}")
except Exception as e:
    print(f"⚠️ Unexpected error: {str(e)}")
