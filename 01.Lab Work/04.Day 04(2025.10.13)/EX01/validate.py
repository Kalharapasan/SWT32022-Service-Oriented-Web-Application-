from lxml import etree

# Load XML and XSD files
xml_file = "bookstore.xml"
xsd_file = "bookstore.xsd"

# Parse XML and XSD
xml_doc = etree.parse(xml_file)
xsd_doc = etree.parse(xsd_file)

# Create XML Schema object
schema = etree.XMLSchema(xsd_doc)

# Validate XML
is_valid = schema.validate(xml_doc)

print("Is XML valid?", is_valid)

# If invalid, print error log
if not is_valid:
    for error in schema.error_log:
        print(f"Line {error.line}: {error.message}")
