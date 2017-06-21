CREATE TABLE alert_entries
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  description BLOB,
  expires BIGINT(20),
  meta__last_updated_at DATETIME NOT NULL,
  severity VARCHAR(255),
  time BIGINT(20),
  title VARCHAR(255),
  uri VARCHAR(255),
  meta__version BIGINT(20),
  forecast_id BIGINT(20)
);
CREATE TABLE cities
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  meta__last_updated_at DATETIME NOT NULL,
  latitude VARCHAR(255),
  longitude VARCHAR(255),
  city_name VARCHAR(255),
  meta__version BIGINT(20),
  region_id BIGINT(20),
  timezone VARCHAR(255)
);
CREATE TABLE current_forecasts
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  apparent_temperature DECIMAL(38),
  cloud_cover DECIMAL(38),
  meta__created_at DATETIME NOT NULL,
  dew_point DECIMAL(38),
  humidity DECIMAL(38),
  icon VARCHAR(255),
  meta__last_updated_at DATETIME NOT NULL,
  neareset_storm_bearing DECIMAL(38),
  nearest_storm_distance DECIMAL(38),
  ozone DECIMAL(38),
  precip_intensity DECIMAL(38),
  precip_intensity_error DECIMAL(38),
  precip_probability DECIMAL(38),
  precip_temperature DECIMAL(38),
  precip_type VARCHAR(255),
  pressure DECIMAL(38),
  summary VARCHAR(255),
  temperature DECIMAL(38),
  time BIGINT(20),
  uv_index DECIMAL(38),
  meta__version BIGINT(20),
  visibitiliy DECIMAL(38),
  wind_bearing DECIMAL(38),
  wind_speed DECIMAL(38),
  forecast_id BIGINT(20)
);
CREATE TABLE daily_data_entries
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  apparent_temperature_min_time BIGINT(20),
  apparent_temperature_max DECIMAL(7,3),
  apparent_temperature_max_time BIGINT(20),
  apparent_temperature_min DECIMAL(7,3),
  cloud_cover DECIMAL(7,3),
  meta__created_at DATETIME NOT NULL,
  dewpoint DECIMAL(7,3),
  humidity DECIMAL(7,3),
  icon VARCHAR(255),
  meta__last_updated_at DATETIME NOT NULL,
  moon_phase DECIMAL(7,3),
  ozone DECIMAL(7,3),
  precip_intensity DECIMAL(7,3),
  precip_intensity_max DECIMAL(7,3),
  precip_intensity_max_time BIGINT(20),
  precip_probability DECIMAL(7,3),
  PRECIPTYPE VARCHAR(255),
  pressure DECIMAL(7,3),
  summary VARCHAR(255),
  sunrise_time BIGINT(20),
  sunset_time BIGINT(20),
  temperature DECIMAL(7,3),
  temperature_max DECIMAL(7,3),
  temperature_max_time BIGINT(20),
  temperature_min DECIMAL(7,3),
  temperature_min_time BIGINT(20),
  time BIGINT(20),
  meta__version BIGINT(20),
  visibility DECIMAL(7,3),
  wind_bearing INT(11),
  wind_speed DECIMAL(7,3),
  daily_id BIGINT(20)
);
CREATE TABLE daily_forecasts
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  icon VARCHAR(255),
  meta__last_updated_at DATETIME NOT NULL,
  summary VARCHAR(255),
  meta__version BIGINT(20),
  forecast_id BIGINT(20)
);
CREATE TABLE forecasts
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  meta__last_updated_at DATETIME NOT NULL,
  timezone VARCHAR(255),
  meta__version BIGINT(20),
  region_id BIGINT(20)
);
CREATE TABLE hourly_data_entries
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  apparent_temperature DECIMAL(7,3),
  cloud_cover DECIMAL(7,3),
  meta__created_at DATETIME NOT NULL,
  dewpoint DECIMAL(7,3),
  humidity DECIMAL(7,3),
  icon VARCHAR(255),
  meta__last_updated_at DATETIME NOT NULL,
  ozone DECIMAL(7,3),
  precip_intensity DECIMAL(7,3),
  precip_probability DECIMAL(7,3),
  precip_type VARCHAR(255),
  pressure DECIMAL(7,3),
  summary VARCHAR(255),
  temperature DECIMAL(7,3),
  time BIGINT(20),
  meta__version BIGINT(20),
  visibility DECIMAL(7,3),
  wind_bearing INT(11),
  wind_speed DECIMAL(7,3),
  hourly_id BIGINT(20)
);
CREATE TABLE hourly_forecasts
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  icon VARCHAR(255),
  meta__last_updated_at DATETIME NOT NULL,
  summary VARCHAR(255),
  meta__version BIGINT(20),
  forecast_id BIGINT(20)
);
CREATE TABLE regions
(
  ID BIGINT(20) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  meta__created_at DATETIME NOT NULL,
  language VARCHAR(5),
  meta__last_updated_at DATETIME NOT NULL,
  regionCode VARCHAR(5),
  units VARCHAR(5),
  meta__version BIGINT(20)
);
ALTER TABLE alert_entries ADD FOREIGN KEY (forecast_id) REFERENCES forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_alert_entries_forecast_id ON alert_entries (forecast_id);
ALTER TABLE cities ADD FOREIGN KEY (region_id) REFERENCES regions (ID);
CREATE INDEX FK_cities_region_id ON cities (region_id);
ALTER TABLE current_forecasts ADD FOREIGN KEY (forecast_id) REFERENCES forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_current_forecasts_forecast_id ON current_forecasts (forecast_id);
ALTER TABLE daily_data_entries ADD FOREIGN KEY (daily_id) REFERENCES daily_forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_daily_data_entries_daily_id ON daily_data_entries (daily_id);
ALTER TABLE daily_forecasts ADD FOREIGN KEY (forecast_id) REFERENCES forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_daily_forecasts_forecast_id ON daily_forecasts (forecast_id);
ALTER TABLE forecasts ADD FOREIGN KEY (region_id) REFERENCES regions (ID);
CREATE INDEX FK_forecasts_region_id ON forecasts (region_id);
ALTER TABLE hourly_data_entries ADD FOREIGN KEY (hourly_id) REFERENCES hourly_forecasts (ID) ON DELETE CASCADE;
ALTER TABLE hourly_data_entries ADD FOREIGN KEY (hourly_id) REFERENCES hourly_forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_hourly_data_entries_hourly_id ON hourly_data_entries (hourly_id);
ALTER TABLE hourly_forecasts ADD FOREIGN KEY (forecast_id) REFERENCES forecasts (ID) ON DELETE CASCADE;
CREATE INDEX FK_hourly_forecasts_forecast_id ON hourly_forecasts (forecast_id);