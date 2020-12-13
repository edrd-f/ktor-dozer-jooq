package edrd.explore.config

object DevelopmentConfig : Config() {
  override val databaseUrl = "jdbc:postgresql://localhost:5432/postgres"
  override val databaseUser = "postgres"
  override val databasePassword = "postgrespassword"
}
