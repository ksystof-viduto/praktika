#!/bin/bash

# Nuskaitome tarnybos pavadinimą iš komandų eilutės įvesties srauto
service_name="$1"

# Patikriname ar tarnyba veikia
service_status=$(systemctl is-active "$service_name")

# Jei tarnyba neveikia, bandoma ją paleisti
if [ "$service_status" != "active" ]; then
    echo "Tarnyba $service_name neveikia. Bandoma paleisti..."
    systemctl start "$service_name"

    # Patikriname ar tarnyba sėkmingai paleista
    service_status_after_start=$(systemctl is-active "$service_name")
    if [ "$service_status_after_start" != "active" ]; then
        echo "Klaida paleidžiant tarnybą $service_name. Įrašoma į klaidų žurnalą daemon-error.log."
        echo "$(date) - Klaida paleidžiant tarnybą $service_name" >> daemon-error.log
    else
        echo "Tarnyba $service_name sėkmingai paleista."
    fi
else
    echo "Tarnyba $service_name veikia."
fi
