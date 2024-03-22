#!/bin/bash

# Specify the Java version
java_version="jdk-22_linux-x64_bin.deb"

# Function to delete previously installed JDK
delete_previous_installation() {
    if dpkg -l | grep -q "oracle-java22-installer"; then
        sudo apt-get purge oracle-java22-installer -y
        echo "Previous JDK installation removed."
    fi
}

# Function to check if Java is installed
check_java_installed() {
    if java -version >/dev/null 2>&1; then
        read -p "Java is already installed. Do you want to reinstall it? (y/n): " reinstall
        if [ "$reinstall" != "y" ]; then
            echo "Exiting script."
            exit 0
        else
            delete_previous_installation
        fi
    fi
}

# Step 0: Check if Java is already installed
check_java_installed

# Check if the file exists before installation
if [ -f $java_version ]; then
    echo "File is already downloaded"
else
    # Step 1: Download JDK .deb package
    wget https://download.oracle.com/java/22/latest/$java_version
fi

# Check if the file exists
if [ -f $java_version ]; then
    # Step 2: Install JDK from the .deb package
    echo "Installing JDK..."
    sudo dpkg -i $java_version
    if [ $? -eq 0 ]; then
        echo "JDK installation completed."
    else
        echo "JDK installation failed."
        exit 1
    fi

    # Step 3: Verify installation
    java -version
else
    echo "Failed to download JDK package."
    exit 1
fi
