param([string]$table, [string]$file)

if (-not $table -or -not $file) {
  Write-Host "Usage: ./import.ps1 <table> <file>"
  exit 1
}

psql $Env:DB_URL -U $Env:DB_USER -c "\\copy $table from '$file' csv header"
