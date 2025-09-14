param([string]$table)

if (-not $table) {
  Write-Host "Usage: ./export.ps1 <table>"
  exit 1
}

psql $Env:DB_URL -U $Env:DB_USER -c "\\copy $table to 'export_$table.csv' csv header"
