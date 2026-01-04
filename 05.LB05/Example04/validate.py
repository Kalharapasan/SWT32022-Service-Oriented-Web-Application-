from lxml import etree
import os

# Get the directory of the current script
script_dir = os.path.dirname(os.path.abspath(__file__))

# Load XML and XSD files using absolute paths
xml_file = os.path.join(script_dir, "employees.xml")
xsd_file = os.path.join(script_dir, "employees.xsd")

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
