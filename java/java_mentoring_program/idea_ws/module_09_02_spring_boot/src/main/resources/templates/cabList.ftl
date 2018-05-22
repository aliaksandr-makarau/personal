<!DOCTYPE html>
<html lang="en">
    <body>
        <h2>List of cabs</h2>
        <table>
            <thead>
                <th>Car make</th>
                <th>Licence plate</th>
                <th>Manufacture year</th>
                <th>Has baby chair</th>
            </thead>
            <tbody>
                <#list cabs as cab>
                    <tr>
                        <td>${cab.carMake}</td>
                        <td>${cab.licencePlate}</td>
                        <td>${cab.manufactureYear}</td>
                        <td>${cab.hasBabyChair?string('yes','no')}</td>
                    </tr>
                </#list>
            </tbody>
        </table>
    </body>
</html>