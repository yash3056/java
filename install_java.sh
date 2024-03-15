#!/bin/bash

# Function to delete previously installed JDK
delete_previous_installation() {
    if dpkg -l | grep -q "oracle-java21-installer"; then
        sudo apt-get purge oracle-java21-installer -y
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

# Check if the file already exists
if [ -f jdk-21.0.2_linux-x64_bin.deb ]; then
    echo "File is already downloaded"
else
    # Step 1: Download JDK .deb package
    wget https://download.oracle.com/java/21/archive/jdk-21.0.2_linux-x64_bin.deb
fi

# Check if the file exists before installation
if [ -f jdk-21.0.2_linux-x64_bin.deb ]; then
    # Step 2: Check if Java is already installed
    check_java_installed
    
    # Step 3: Install JDK from the .deb package
    echo "Installing JDK..."
    sudo dpkg -i jdk-21.0.2_linux-x64_bin.deb
    if [ $? -eq 0 ]; then
        echo "JDK installation completed."
    else
        echo "JDK installation failed."
        exit 1
    fi

    # Step 4: Verify installation
    java -version
fi
